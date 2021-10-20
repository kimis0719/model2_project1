package util;

public class Pager {

	private Integer curPage;	//현재 페이지 번호
	private Integer perPage;	//불러올 페이지 개수
	
	//DB
	private Integer startRow;	//시작 rownum
	private Integer lastRow;	//마지막 rownum
	
	//View
	private Integer startNum;	//시작 번호
	private Integer lastNum;	//마지막 번호
	private Integer curBlock;	//현재 블럭 번호
	private Integer totalBlock;	//전체 블럭 개수
	
//	private String kind;//검색종류
//	private String search;//검색어
	
	public Integer getCurPage() {
		if(curPage == null || curPage == 0) {
			curPage = 1;
		}
		
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPerPage() {
		if(perPage == null || perPage == 0) {
			perPage = 10;
		}
		
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getLastRow() {
		return lastRow;
	}
	public void setLastRow(Integer lastRow) {
		this.lastRow = lastRow;
	}
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getLastNum() {
		return lastNum;
	}
	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}
	public Integer getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Integer curBlock) {
		this.curBlock = curBlock;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
//	public String getKind() {
//		return kind;
//	}
//	public void setKind(String kind) {
//		this.kind = kind;
//	}
//	public String getSearch() {
//		if(search == null) {
//			search="";
//		}
//		return search;
//	}
//	public void setSearch(String search) {
//		this.search = search;
//	}
	
	//makeRow : rownum 시작 번호, 끝 번호 만들기
	public void makeRow() {
		//시작 rownum = (현재 페이번호 -1)*불러올 페이지 개수 +1
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		//끝 rownum = 현재 페이지번호 * 불러올 페이지 개수
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	//makePage : 페이지 처리
	public void makePage(int totalCount) {
		//1. 전체 글의 개수를 DB에서 매개변수로 받아옴 : totalCount
		
		//2. 전체 페이지 개수 = 전체 글 개수 / 불러올 페이지 당 글 개수(10)
		int totalPage = totalCount/this.getPerPage();
		//	글개수가 perPage보다 작으면(나머지가 0이 아닐 때)
		if(totalCount%this.getPerPage()!=0) {
			//전체 페이지 개수 +1
			totalPage++;
		}
		
		//3. totalBlock(전체 블록 개수)
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		//4. curPage로 curBlock 구하기
		curBlock = this.getCurPage() /perBlock;
		if(this.getCurPage()%perBlock != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 구하기
		startNum = (curBlock-1)*perBlock +1;
		lastNum = curBlock*perBlock;
		
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
	}

}
