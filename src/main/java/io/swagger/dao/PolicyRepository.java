package io.swagger.dao;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.google.cloud.spring.data.spanner.repository.SpannerRepository;
import com.google.cloud.spring.data.spanner.repository.query.Query;
import io.swagger.entity.*;

@Repository
public interface PolicyRepository extends SpannerRepository<PolicyDetail, String> {

  @Query ("SELECT * from policies where coverageId=: coverageId")
  List<PolicyDetail> findByCoverageId(@Param("coverageId") String coverageId);
}
