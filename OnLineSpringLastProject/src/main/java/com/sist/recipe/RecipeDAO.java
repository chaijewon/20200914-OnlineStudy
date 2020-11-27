package com.sist.recipe;
import com.mongodb.*;
public class RecipeDAO {
    private MongoClient mc;
    private DB db;
    private DBCollection dbc;
    public RecipeDAO()
    {
    	try
    	{
    		mc=new MongoClient("localhost",27017);
    		db=mc.getDB("mydb");
    		dbc=db.getCollection("chef");
    	}catch(Exception ex){}
    }
    public void recipeInsert(RecipeVO vo)
    {
    	/*
    	 *   private int no;
		     private String title;
		     private String poster;
		     private String chef;
		     private String link;
    	 */
    	try
    	{
    		BasicDBObject obj=new BasicDBObject();
    		obj.put("no", vo.getNo());
    		obj.put("title", vo.getTitle());
    		obj.put("poster", vo.getPoster());
    		obj.put("chef", vo.getChef());
    		obj.put("link", vo.getLink());
    		
    		dbc.insert(obj);
    	}catch(Exception ex){}
    }
    public void chefInsert(ChefVO vo)
    {
    	/*
    	 *  private String poster;
		    private String chef;
		    private String mem_cont1;
		    private String mem_cont3;
		    private String mem_cont7;
		    private String mem_cont2;
    	 */
    	try
    	{
    		BasicDBObject obj=new BasicDBObject();
    		obj.put("chef", vo.getChef());
    		obj.put("poster", vo.getPoster());
    		obj.put("mc1", vo.getMem_cont1());
    		obj.put("mc2", vo.getMem_cont2());
    		obj.put("mc3", vo.getMem_cont3());
    		obj.put("mc7", vo.getMem_cont7());
    		
    		dbc.insert(obj);
    	}catch(Exception ex){}
    }
    public void recipeDetailData(RecipeDetailVO vo)
    {
    	/*
    	 *  private String poster;
		   private String title;
		   private String chef;
		   private String chef_poster;
		   private String chef_profile;
		   private String info1,info2,info3;
		   private String content;
		   private String foodmake;
    	 */
    	try
    	{
    		
    		BasicDBObject obj=new BasicDBObject();
    		obj.put("no", vo.getNo());
    		obj.put("poster", vo.getPoster());
    		obj.put("title", vo.getTitle());
    		obj.put("chef", vo.getChef());
    		obj.put("chef_poster", vo.getChef_poster());
    		obj.put("chef_profile", vo.getChef_profile());
    		obj.put("info1", vo.getInfo1());
    		obj.put("info2", vo.getInfo2());
    		obj.put("info3", vo.getInfo3());
    		obj.put("content", vo.getContent());
    		obj.put("foodmake", vo.getFoodmake());
    		
    		dbc.insert(obj);
    	}catch(Exception ex){}
    }
}













