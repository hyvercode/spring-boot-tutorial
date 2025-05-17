package com.hyvercode.spring.model.response;


import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse implements Serializable {
    private int bookId;
    private String bookName;
}
