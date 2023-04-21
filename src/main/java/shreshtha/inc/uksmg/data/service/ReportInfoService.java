package shreshtha.inc.uksmg.data.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import shreshtha.inc.uksmg.data.entity.ReportInfo;

@Service
public class ReportInfoService {

    private final ReportInfoRepository repository;

    public ReportInfoService(ReportInfoRepository repository) {
        this.repository = repository;
    }

    public Optional<ReportInfo> get(Long id) {
        return repository.findById(id);
    }

    public ReportInfo update(ReportInfo entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<ReportInfo> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<ReportInfo> list(Pageable pageable, Specification<ReportInfo> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
