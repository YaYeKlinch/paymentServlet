package com.example.payment.controller.command.impl.user_payment;

import com.example.payment.controller.command.PostCommand;
import com.example.payment.entity.CreditCard;
import com.example.payment.entity.Payment;
import com.example.payment.entity.User;
import com.example.payment.entity.dto.UserPaymentDto;
import com.example.payment.service.account.AccountService;
import com.example.payment.service.account.AccountServiceImpl;
import com.example.payment.service.creditCard.CreditCardService;
import com.example.payment.service.creditCard.CreditCardServiceImpl;
import com.example.payment.service.payment.PaymentService;
import com.example.payment.service.payment.PaymentServiceImpl;
import com.example.payment.service.userPayment.UserPaymentService;
import com.example.payment.service.userPayment.UserPaymentServiceImpl;
import org.omg.CosNaming._BindingIteratorImplBase;

import javax.servlet.http.HttpServletRequest;

import static com.example.payment.controller.command.uttils.SessionUtils.getUserId;

public class PostMakingPayment implements PostCommand {
    UserPaymentService userPaymentService = new UserPaymentServiceImpl();
    CreditCardService cardService = new CreditCardServiceImpl();
    PaymentService paymentService = new PaymentServiceImpl();
    AccountService accountService = new AccountServiceImpl();
    private static final String URL_ERROR = "makePayment.jsp";
    private static final String URL_SUCCESS = "/";
    boolean allMatches;
    @Override
    public String execute(HttpServletRequest request) {
        long paymentId = Long.parseLong(request.getParameter("payment_id"));
        Payment payment = paymentService.findById(paymentId);
        User user = getUserId(request);
        UserPaymentDto userPaymentDto = createDto(request);
        CreditCard card = findCard(request , userPaymentDto);
        if(card.getPin()!=userPaymentDto.getPin()){
            request.setAttribute("PinNotMatch" , true);
            return URL_ERROR;
        }
        if(tryCreateUserPayment(request,payment , userPaymentDto,card,user)){
            accountService.spendMoney(card.getAccount() , userPaymentDto.getCosts());
            return URL_SUCCESS;
        }

        return URL_ERROR;
    }
    @Override
    public boolean isError(String url) {
        return url.equals(URL_ERROR);
    }

    private boolean tryCreateUserPayment(HttpServletRequest request , Payment payment , UserPaymentDto userPaymentDto , CreditCard card , User user){
        if(userPaymentService.createUserPayment(userPaymentDto,card,payment,user)){
            return true;
        } else{
            request.setAttribute("paymentEx" , true);
            return false;
        }
    }
    private CreditCard findCard(HttpServletRequest request, UserPaymentDto userPaymentDto){
        CreditCard card = null;
        try {
           card = cardService.findByNumber(userPaymentDto.getNumber());
        }catch (Exception ex){
            allMatches = false;
            request.setAttribute("CardNotFind",true);
        }
        return card;
    }

    private UserPaymentDto createDto(HttpServletRequest request){
       UserPaymentDto userPaymentDto = null;
        try {
            userPaymentDto = new UserPaymentDto(
                    Long.parseLong(request.getParameter("number")),
                    Integer.parseInt(request.getParameter("costs")),
                    Integer.parseInt(request.getParameter("pin")));

        }catch (Exception ex){
            allMatches = false;
        }
        return userPaymentDto;
    }

}
