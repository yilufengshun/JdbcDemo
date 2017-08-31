package com.mengxs.day34;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Dogdao dogdao=new Dogdao();
			//dogdao.insert(new Dog(2, "阿黄", 12, 89,"中华田园犬"));
		//	dogdao.update(new Dog(0, "阿ap", 12, 89,"中华田园犬"));
			List<Dog> dogs=dogdao.find();
			if(dogs!=null){
				for (Dog dog : dogs) {
					System.out.println(dog);
				}
			}
			MasterDao md=new MasterDao();
//			md.add(new Master(2, "主人2", "hehehe", 1222));
	//	md.updata(new Master(1, "主人", "mima", 111));
	//		md.delete(2);
		List<Master> al=md.findall();
		for (Master master : al) {
			System.out.println(master);
		}
	
	}

}
