public class Collection02_SetTest{
	pubic static void main(String[] args){
		//Set: 순서 X, 중복 X
		
		Set<String> names=new HashSet<>();
		
		names.add("유아름");
		names.add("강건");
		names.add("박승연");
		names.add("강건");
		names.add("왕성민");
		names.add("강건");
		
		System.out.println(names);
		}
	}
