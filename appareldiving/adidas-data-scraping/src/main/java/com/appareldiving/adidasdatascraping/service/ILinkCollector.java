package com.appareldiving.adidasdatascraping.service;


import com.appareldiving.adidasdatascraping.util.exceptions.InputUrlIsNull;

import java.io.IOException;
import java.util.List;

public interface ILinkCollector {


    List<String> collectProductLinks(String navigationLink, int quantity) throws IOException, InputUrlIsNull;

}
