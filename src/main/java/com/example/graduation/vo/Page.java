package com.example.graduation.vo;

public class Page {
	
	private int currentPage;//第几数
	private int allRecord;	//所有页
	private int lineSize;	//每页个记录(固定值)
	private int lineCount;	//每页个记录(第一页，最后一页，页的大小已处理)
	private int pageSize;	//页数
	public Page(){
		this.currentPage = 1;
		this.lineSize = 4;
	}
	
	public Page(int allRecord, int lineSize){
		this.currentPage = 1;
		this.lineSize = lineSize;
		this.lineCount = lineSize;
		this.allRecord = allRecord;
		update();
	}

	public int getCurrentPage() {
		return currentPage;
	}
	private void update() {
		if(allRecord>lineSize&&currentPage==pageSize){//最后一页，页的大小
			lineCount=allRecord-(pageSize-1)*lineSize;
		}else if(allRecord<=lineSize&&allRecord>=0){		//第一页,页的大小
			lineCount=allRecord;
		}else{
			lineCount=lineSize;
		}
		//更新页数
		if(allRecord!=0&&allRecord%lineSize==0) {
			pageSize = allRecord / lineSize;
		}else if(allRecord!=0&&allRecord%lineSize!=0){
			pageSize = (allRecord / lineSize)+1;
		}else{
			pageSize=0;
		}
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		if(currentPage<=0){
			this.currentPage=1;
		}
		if(currentPage>pageSize){
			this.currentPage=pageSize;
		}
		update();//如果为第一页,最后一页时，更新页大小
	}

	public int getLineSize() {
		return lineSize;
	}

	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
		update();//更新页数
	}

	public int getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(int allRecord) {
		this.allRecord = allRecord;
		update();//更新页数
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}