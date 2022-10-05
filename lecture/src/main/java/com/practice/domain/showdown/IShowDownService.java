package com.practice.domain.showdown;

public interface IShowDownService {

    /**
     * プレイヤー視点からの結果（bool値）を返す
     * @param showDownField
     * @return
     */
    boolean culculate(ShowDownField showDownField);
}
