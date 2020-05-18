package com.ipn.escom.covid.back.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatrixRequest implements Serializable {
    private static final long serialVersionUID = 259303984962443883L;
    private List<Answer> answers;
}
