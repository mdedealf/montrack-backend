package com.mdedealf.montrackbackend.usecase.impl;

import com.mdedealf.montrackbackend.entity.Pockets;
import com.mdedealf.montrackbackend.usecase.GetPocketDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPocketDetailImpl implements GetPocketDetail {


    @Override
    public List<Pockets> getPocket() {
        return List.of();
    }
}
