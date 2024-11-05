package com.mdedealf.montrackbackend.usecase.impl;

import com.mdedealf.montrackbackend.entity.Pocket;
import com.mdedealf.montrackbackend.usecase.GetPocketDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPocketDetailImpl implements GetPocketDetail {


    @Override
    public List<Pocket> getPocket() {
        return List.of();
    }
}
