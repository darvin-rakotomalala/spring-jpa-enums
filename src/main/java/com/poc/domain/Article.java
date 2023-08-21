package com.poc.domain;

import com.poc.domain.constant.Category;
import com.poc.domain.constant.Status;
import com.poc.domain.constant.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "articles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseDO {
    private String title;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Type type;
    private Category category;
}
