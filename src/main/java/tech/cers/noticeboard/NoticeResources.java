package tech.cers.noticeboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.cers.noticeboard.services.NoticeService;
import tech.cers.noticeboard.models.Notice;
import tech.cers.noticeboard.models.search.PagedResponse;
import tech.cers.noticeboard.models.search.SearchRequest;


@RestController
@RequestMapping("/notice")
public class NoticeResources {
  private final NoticeService noticeService;

  public NoticeResources(NoticeService noticeService) {
    this.noticeService = noticeService;
  }

  @GetMapping("/all")
  public ResponseEntity<PagedResponse<Notice>> getAllNotices(SearchRequest request) {
    PagedResponse<Notice> notices = noticeService.getAllNotices(request);
    return new ResponseEntity<>(notices, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<Notice> getNoticeById(@PathVariable("id") Long id) {
    Notice notice = noticeService.findNoticeById(id);
    return new ResponseEntity<>(notice, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Notice> addNotice(@RequestBody Notice notice){
    Notice newNotice = noticeService.addNotice(notice);
    return new ResponseEntity<>(newNotice, HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<Notice> updateNotice(@RequestBody Notice notice){
    Notice updateNotice = noticeService.updateNotice(notice);
    return new ResponseEntity<>(updateNotice, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Notice> deleteNotice(@PathVariable("id") Long id){
    noticeService.deleteNotice(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
