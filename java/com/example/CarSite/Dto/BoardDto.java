package com.example.CarSite.Dto;

import com.example.CarSite.Entity.Board;
import lombok.Data;

@Data
public class BoardDto {
    private Long id;
    private String title;
    private String writer;
    private String text;

    public static BoardDto boardDto(Board board){
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setTitle(board.getTitle());
        boardDto.setWriter(board.getWriter());
        boardDto.setText(board.getText());
        return boardDto;
    }
}
