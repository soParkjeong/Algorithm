import java.util.*;

class Solution {

    static class Song {
        int id;//고유 번호
        int play;//재생 수

        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // 장르별 재생수
        HashMap<String, Integer> totalMap = new HashMap<>();

        // 장르별 노래 리스트
        HashMap<String, ArrayList<Song>> songsMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];//장르
            int p = plays[i];//재생 수

            //총합
            totalMap.put(g, totalMap.getOrDefault(g, 0) + p);

            // 노래 리스트 추가
            if (!songsMap.containsKey(g)) {
                songsMap.put(g, new ArrayList<Song>());
            }
            songsMap.get(g).add(new Song(i, p));
        }

        // 장르 정렬(재생수 내림차순)
        ArrayList<String> genreList = new ArrayList<>(totalMap.keySet());
        Collections.sort(genreList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(totalMap.get(b), totalMap.get(a));
            }
        });

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < genreList.size(); i++) {
            String g = genreList.get(i);
            ArrayList<Song> list = songsMap.get(g);

            // 노래 정렬(재생 수는 내림차순, 번호는 오름차순으로)
            Collections.sort(list, new Comparator<Song>() {
                @Override
                public int compare(Song s1, Song s2) {
                    if (s1.play != s2.play) {
                        return Integer.compare(s2.play, s1.play);//재생 수는 내림차순
                    }
                    return Integer.compare(s1.id, s2.id);//번호는 오름차순
                }
            });

            //상위 2개 뽑기/1개만 담겨있으면 한 곡만 선택 조건
            answer.add(list.get(0).id);
            if (list.size() > 1) {
                answer.add(list.get(1).id);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
