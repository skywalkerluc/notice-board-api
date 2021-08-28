package tech.cers.noticeboard.models.search.util;

import tech.cers.noticeboard.models.search.PageRequest;
import tech.cers.noticeboard.models.search.SearchRequest;

public final class SearchRequestUtil {
  private static final int DEFAULT_PAGE_SIZE = 9;
  private SearchRequestUtil(){ }

  public static PageRequest toPageRequest(final SearchRequest request) {
    if(request == null){
      return new PageRequest(0, DEFAULT_PAGE_SIZE);
    }

    final int requestedSize = request.getSize();
    return new PageRequest(request.getPage(), requestedSize == 0 ? DEFAULT_PAGE_SIZE : requestedSize);
  }
}
