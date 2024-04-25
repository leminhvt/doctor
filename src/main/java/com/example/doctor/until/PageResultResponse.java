package com.example.doctor.until;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResultResponse<T> {
    private List<T> content;
    private Integer pageIndex;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private Boolean last;


    public List<T> getContent() {
        return content == null ? null : new ArrayList<>(content);
    }

    public final void setContent(List<T> content) {
        if (content == null) {
            this.content = null;
        } else {
            this.content = Collections.unmodifiableList(content);
        }
    }
}
