package com.ipn.escom.covid.back.dto;

import com.ipn.escom.covid.back.entity.Grupo;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class GroupsDto implements Serializable {
    private static final long serialVersionUID = -7907743529079454795L;
    private List<Grupo> groups;
}
