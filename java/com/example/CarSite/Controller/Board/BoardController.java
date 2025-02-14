package com.example.CarSite.Controller.Board;

import com.example.CarSite.Dto.BoardDto;
import com.example.CarSite.Entity.Board;
import com.example.CarSite.Service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String start(){
        return "board/board";
    }
    @PostMapping
    public String Board(Board board){
        BoardDto boardDto = BoardDto.boardDto(board);
        boardService.save(boardDto);
        return "board/board";
    }
}
