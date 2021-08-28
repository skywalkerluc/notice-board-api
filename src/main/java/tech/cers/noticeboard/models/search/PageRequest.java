package tech.cers.noticeboard.models.search;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

public class PageRequest extends AbstractPageRequest {

  public PageRequest(int page, int size) {
    super(page, size);
  }

  @Override
  public Sort getSort() {
    return Sort.unsorted();
  }

  @Override
  public Pageable next(){
    throw new UnsupportedOperationException();
  }

  @Override
  public Pageable previous() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Pageable first() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Pageable withPage(int pageNumber) {
    throw new UnsupportedOperationException();
  }
}
