package com.Backend.LibraryManagementSystem.Controller;

import com.Backend.LibraryManagementSystem.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("add")
    public String addCard(){

        return cardService.addNewCard();
    }

    @PutMapping("associateCardAndStudent")
    public String associateCardAndStudent(@RequestParam("cardId")Integer cardId,
                                          @RequestParam("studentId")Integer studentId) {

        return cardService.associateCardAndStudent(cardId,studentId);
    }
}
