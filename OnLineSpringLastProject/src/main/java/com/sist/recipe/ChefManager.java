package com.sist.recipe;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 *  <div class="list_mem3">
                <a href="/profile/index.html?uid=43861990" class="mem_pic"><img src="http://recipe1.ezmember.co.kr/cache/rpf/2015/07/28/9b9a28484d3ed1fa63ca699aaba60d781.jpg" ></a>
            </div>
            <div class="list_cont4"><b>
                <a href="/profile/index.html?uid=43861990" id="folFriend_43861990" class="info_name_f">
                    내조의여왕닝닝                </a>
                    <button type="button" class="btn btn-default btn-sm" id="btnActFriend_43861990" fact="insert" onClick="doActFriend('43861990')">
                        <span class="glyphicon glyphicon-plus"></span>소식받기                    </button>
                </b>
                <span class="mem_cont1">0</span><span class="mem_cont3">0</span><span class="mem_cont7">0</span><span class="mem_cont2">2</span>
            </div>
        </div>

 */
import java.io.*;

public class ChefManager {
    private static ArrayList<ChefVO> chefList=
    		   new ArrayList<ChefVO>();
    static 
    {
    	try
    	{
    		FileInputStream fis=
    				new FileInputStream("c:\\project_data\\chef.txt");
    		ObjectInputStream ois=
    				new ObjectInputStream(fis);
    		chefList=(ArrayList<ChefVO>)ois.readObject();
    		ois.close();
    	}catch(Exception ex) {}
    }
    //  목록출력 
    public ArrayList<ChefVO> chefListData(int page)
    {
    	ArrayList<ChefVO> list=
    			new ArrayList<ChefVO>();
    	int rowSize=10;
    	int pagecnt=(page*rowSize)-rowSize;
    	for(int i=pagecnt;i<pagecnt+rowSize;i++)
    	{
    		list.add(chefList.get(i));
    	}
    	return list;
    }
    public int chefTotal()
    {
    	return (int)(Math.ceil(chefList.size()/10.0));
    }
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChefManager cm=new ChefManager();
		ArrayList<ChefVO> list=cm.chefAllData();
		for(ChefVO vo:list)
		{
			System.out.println(vo.getChef());
			System.out.println(vo.getPoster());
			System.out.println(vo.getMem_cont1()+" "
					+vo.getMem_cont3()+" "
					+vo.getMem_cont7()+" "
					+vo.getMem_cont2());
		}
		
		try
		{
			FileOutputStream fos=
					new FileOutputStream("c:\\project_data\\chef.txt");
			ObjectOutputStream oos=
					new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
		}catch(Exception ex) {}
		
		System.out.println("저장 완료");

	}
	public ArrayList<ChefVO> chefAllData()
	{
		ArrayList<ChefVO> list=new ArrayList<ChefVO>();
		try
		{
			for(int i=1;i<=22;i++)
			{
				Document doc=Jsoup.connect("http://www.10000recipe.com/chef/chef_list.html?order=chef_no_follower&term=all&page="+i).get();
				Elements poster=doc.select("div.list_mem3 a.mem_pic img");
				Elements chef=doc.select("div.list_cont4 a");
				Elements mem_cont1=doc.select("span.mem_cont1");
				Elements mem_cont3=doc.select("span.mem_cont3");
				Elements mem_cont7=doc.select("span.mem_cont7");
				Elements mem_cont2=doc.select("span.mem_cont2");
				
				for(int j=0;j<poster.size();j++)
				{
					ChefVO vo=new ChefVO();
					vo.setPoster(poster.get(j).attr("src"));
					vo.setChef(chef.get(j).text());
					vo.setMem_cont1(mem_cont1.get(j).text());
					vo.setMem_cont3(mem_cont3.get(j).text());
					vo.setMem_cont7(mem_cont7.get(j).text());
					vo.setMem_cont2(mem_cont2.get(j).text());
					
					list.add(vo);
				}
			}
		}catch(Exception ex){ex.printStackTrace();}
		return list;
	}
	*/

}







