package com.rdsms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.rdsms.entity.MIS;
import java.io.Serializable;

public interface MisRepository  extends PagingAndSortingRepository<MIS, Serializable>{

}
