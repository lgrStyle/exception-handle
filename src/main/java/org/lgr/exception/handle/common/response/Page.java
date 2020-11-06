package org.lgr.exception.handle.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Page<T> {
    private Integer total;
    private Integer pageNo;
    private Integer pageSize;
    private T records;

}
