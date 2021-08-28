package tech.cers.noticeboard.models.search;

public class SearchRequest {
  private int size;
  private int page;

  public int getSize() {
    return this.size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getPage() {
    return this.page;
  }

  public void setPage(int page){
    this.page = page;
  }
}
