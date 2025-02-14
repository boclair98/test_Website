package com.example.CarSite.Service;

import com.example.CarSite.Dto.BoardDto;
import com.example.CarSite.Entity.Board;
import com.example.CarSite.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    private static BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }
    
    //게시판 저장
    public void save(BoardDto boardDto){
        Board board = Board.board(boardDto);
        boardRepository.save(board);
    }

    //게시글 꺼내오기
    public Optional<Board> find(Long id){
        return boardRepository.findById(id);
    }
}
