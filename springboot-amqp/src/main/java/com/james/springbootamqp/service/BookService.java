package com.james.springbootamqp.service;

import com.james.springbootamqp.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "tfd.news")
    public void receive(Book book) {
        System.out.println("收到消息 " + book);
    }
}
