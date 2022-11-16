package com.li.affection.service;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.DetailInformation;

public interface DetailInformationService {
    ResponseResult getDetailInformation();
    ResponseResult updateDetailInformation(DetailInformation detailInformation);
    ResponseResult addDetailInformation(DetailInformation detailInformation);
}
