package tech.cers.noticeboard.services;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import tech.cers.noticeboard.models.Notice;
import tech.cers.noticeboard.models.search.PagedResponse;
import tech.cers.noticeboard.models.search.SearchRequest;
import tech.cers.noticeboard.models.search.util.SearchRequestUtil;
import tech.cers.noticeboard.repo.NoticeRepository;
import tech.cers.noticeboard.exceptions.NoticeNotFoundException;

@Service
public class NoticeService {
  private NoticeRepository noticeRepository;

  public NoticeService(){}

  @Autowired
  public NoticeService(NoticeRepository noticeRepository) {
    this.noticeRepository = noticeRepository;
  }

  public Notice addNotice(Notice notice) {
    return noticeRepository.save(notice);
  }

  public PagedResponse<Notice> getAllNotices(final SearchRequest request) {
    final Page<Notice> response = noticeRepository.findAll(SearchRequestUtil.toPageRequest(request));
    if(response.isEmpty()){
      return new PagedResponse<>(Collections.EMPTY_LIST, 0, response.getTotalElements());
    }

    final List<Notice> responseContent = response.getContent();
    return new PagedResponse<>(responseContent, response.getSize(), response.getTotalElements());
  }

  public Notice updateNotice(Notice updatedNotice){
    return noticeRepository.save(updatedNotice);
  }

  public Notice findNoticeById(Long id){
    return noticeRepository.findNoticeById(id).orElseThrow(() -> new NoticeNotFoundException("Notice search by id " + id + "was not found"));
  }

  public void deleteNotice(Long id){
    noticeRepository.deleteById(id);
  }
}
