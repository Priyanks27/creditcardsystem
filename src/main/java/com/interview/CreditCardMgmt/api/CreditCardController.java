package com.interview.CreditCardMgmt.api;

import com.interview.CreditCardMgmt.data.model.CreditCard;
import com.interview.CreditCardMgmt.data.model.ResponseDTO;
import com.interview.CreditCardMgmt.service.CreditCardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;

@Log
@RestController
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping("/add")
    public ResponseDTO addCreditCard(@RequestBody CreditCard creditCard)
    {
        ResponseDTO responseDTO;
        log.log(Level.INFO, "addCreditCard");
        try
        {
            log.log(Level.INFO, "adding credit card");
            responseDTO = new ResponseDTO(false, "Success", creditCardService.createCreditCard(creditCard));
        } catch (Exception ex){
            log.log(Level.SEVERE, "Exception occurred while adding credit card : " + ex.getStackTrace());
            responseDTO = new ResponseDTO(true, "Error occurred", creditCardService.createCreditCard(creditCard));
        }
        return responseDTO;
    }

    @GetMapping("/getCreditCard/{creditCardId}")
    public ResponseDTO getCreditCard(@PathVariable Long creditCardId)
    {
        ResponseDTO responseDTO;
        log.log(Level.INFO, "getCreditCard");
        try
        {
            log.log(Level.INFO, "getting credit card");
            responseDTO = new ResponseDTO(false, "Success", creditCardService.findCreditCardById(creditCardId));
        } catch (Exception ex){
            log.log(Level.SEVERE, "Exception occurred while getting credit card : " + ex.getStackTrace());
            responseDTO = new ResponseDTO(true, "Error occurred", ex.getMessage());
        }
        return responseDTO;
    }

    @GetMapping("/getAllCreditCardDetails")
    public ResponseDTO getAllCreditCardDetails( @RequestParam Integer limit, @RequestParam Integer offset)
    {
        ResponseDTO responseDTO;
        log.log(Level.INFO, "getAllCreditCard");
        try
        {
            log.log(Level.INFO, "getting all credit card details");
            responseDTO = new ResponseDTO(false, "Success",
                    creditCardService.findAllCreditCards(limit, offset));
        } catch (Exception ex){
            log.log(Level.SEVERE, "Exception occurred while getting credit card : " + ex.getStackTrace());
            responseDTO = new ResponseDTO(true, "Error occurred", ex.getStackTrace());
        }
        return responseDTO;
    }

    @PostMapping("/update/CreditCard")
    public ResponseDTO updateCreditCard(@RequestBody CreditCard creditCard)
    {
        ResponseDTO responseDTO;
        log.log(Level.INFO, "updateCreditCard");
        try
        {
            log.log(Level.INFO, "updating credit card");
            responseDTO = new ResponseDTO(false, "Success", creditCardService.updateCreditCardById(creditCard));
        } catch (Exception ex){
            log.log(Level.SEVERE, "Exception occurred while updating credit card : " + ex.getStackTrace());
            responseDTO = new ResponseDTO(true, "Error occurred", ex.getMessage());
        }
        return responseDTO;
    }

    @GetMapping("/searchCreditCards/{searchString}")
    public ResponseDTO searchCreditCards(@PathVariable Long searchString, @RequestParam Integer limit,
                                                           @RequestParam Integer offset)
    {
        ResponseDTO responseDTO;
        log.log(Level.INFO, "updateCreditCard");
        try
        {
            log.log(Level.INFO, "updating credit card");
            responseDTO = new ResponseDTO(false, "Success",
                    creditCardService.findAllCreditCardsByPagination(searchString, limit, offset));
        } catch (Exception ex){
            log.log(Level.SEVERE, "Exception occurred while updating credit card : " + ex.getStackTrace());
            responseDTO = new ResponseDTO(true, "Error occurred", ex.getStackTrace());
        }
        return responseDTO;
    }
}
