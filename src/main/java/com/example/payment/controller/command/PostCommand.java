package com.example.payment.controller.command;

public interface PostCommand extends Command{
    boolean isError(String url);
}
