package shreshtha.inc.uksmg.data.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import shreshtha.inc.uksmg.data.entity.ReportInfo;

public interface ReportInfoRepository extends JpaRepository<ReportInfo, Long>, JpaSpecificationExecutor<ReportInfo> {

}
