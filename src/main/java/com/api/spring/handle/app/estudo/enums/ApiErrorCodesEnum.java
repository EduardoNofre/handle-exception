package com.api.spring.handle.app.estudo.enums;

import com.api.spring.handle.app.estudo.exceptions.ClienteNaoEncontradoDeleteException;

public enum ApiErrorCodesEnum {

    ECDA001(1, "Missing required parameter: %s"),
    ECDA002(2, "Innapropriate use of %s"),
    ECDA003(3, "Recipient not found", new ClienteNaoEncontradoDeleteException()),
    ECDA004(4, "Innapropriate use of credit card token."),
    ECDA005(5, "Invalid credit card token"),
    ECDA006(6, "Account not found.", new ClienteNaoEncontradoDeleteException()),
    ECDA007(7, "Account holder not found."),
    ECDA009(9, "Forbidden. It's not allowed to alter the TaxIdentifier."),
    ECDA010(10, "Transaction cannot be canceled"),
    ECDA011(11, "Unauthorized action"),
    ECDA012(12, "Invalid attribute"),
    ECDA013(13, "Transaction not found"),
    ECDA014(14, "Invalid taxId"),
    ECDA015(15, "Forbidden. Requester can't access %s data."),
    ECDA016(16, "Insufficient funds", new ClienteNaoEncontradoDeleteException()),
    ECDA017(17, "Unsupported transaction type"),
    ECDA018(18, "All Recipients must be of the same Account Holder"),
    ECDA019(19, "The sum of the recipient amounts cannot be greater than the totalAmount"),
    ECDA020(20, "Bad credentials"),
    ECDA023(23, "Transaction not found"),
    ECDA028(28, "Invalid expiration date"),
    ECDA029(29, "Action not allowed for closed account(s). [%s]"),
    ECDA030(30, "Transaction already canceled."),
    ECDA041(41, "Invalid Password Requirements"),
    ECDA042(42, "Email already exists", new ClienteNaoEncontradoDeleteException()),
    ECDA043(43, "MobilePhone already exists", new ClienteNaoEncontradoDeleteException()),
    ECDA044(44, "TaxId already exists", new ClienteNaoEncontradoDeleteException()),
    ECDA045(45, "Format invalid parameter: %s"),
    ECDA046(46, "An error occurred while generating account."),
    ECDA047(47, "Username already exists"),
    ECDA048(48, "An error occurred during the upload"),
    ECDA049(49, "Invalid format file"),
    ECDA050(50, "Failure when retrieving bank list"),
    ECDA051(51, "Invalid activation code"),
    ECDA053(53, "S3 did not return the uploaded document url."),
    ECDA055(55, "AccountHolder does not have account."),
    ECDA058(58, "Picture profile is not defined"),
    ECDA060(60, "An error occurred while update account"),
    ECDA061(61, "Account holder is different from the informed"),
    ECDA062(62, "Account Holder does not have the taxId informed"),
    ECDA063(63, "Document profile is not defined"),
    ECDA064(64, "Url S3 document profile is incorrect"),
    ECDA065(65, "Phone number not supported"),
    ECDA057(57, "Failure image download"),
    ECDA059(59, "Url S3 profile picture is incorrect"),
    ECDA066(66, "Country not supported"),
    ECDA067(67, "Only one recipient is allowed"),
    ECDA068(68, "Account %s has not been fully created yet"),
    ECDA069(69, "Card BPP not found"),
    ECDA070(70, "Value must be greater than zero"),
    ECDA071(71, "Fail to reload BPP card"),
    ECDA072(72, "Fail to connect BPP server"),
    ECDA073(73, "Unable to reverse the debit transaction"),
    ECDA074(74, "Error to process withdraw transaction"),
    ECDA075(75, "Rejected Payment"),
    ECDA076(76, "Transaction cannot be settled. %s"),
    ECDA077(77, "Fail to request BPP card"),
    ECDA078(78, "Account already has Bpp Card"),
    ECDA079(79, "Disabled payment type: %s"),
    ECDA080(80, "Transaction cannot be rejected. %s"),
    ECDA081(81, "Email not found"),
    ECDA082(82, "Invalid address"),
    ECDA083(83, "Invalid signature"),
    ECDA084(84, "Unregistered device"),
    ECDA085(85, "The destination account tax identifier must be the same as in the origin account."),
    ECDA086(86, "Invalid transaction state"),
    ECDA087(87, "phone number does not match with branch/account data"),
    ECDA088(88, "person does not match with branch/account titular"),
    ECDA089(89, "Invalid credit account"),
    ECDA090(90, "Daily limit exceeded"),
    ECDA091(91, "Value limit exceeded"),
    ECDA092(92, "Max validation attempts exceeded"),
    ECDA093(93, "Credit card not found."),
    ECDA095(95, "3DS Error"),
    ECDA096(96, "Error manipulating Authorized Transaction"),
    ECDA097(97, "%s"),
    ECDA098(98, "%s"),
    ECDA099(99, "Unexpected error"),
    ECDA100(100, "Invalid credit card"),
    ECDA101(101, "Credit card tokenization failed"),
    ECDA102(102, "Invalid account status: %s"),
    ECDA103(103, "Invalid installments value"),
    ECDA104(104, "Invalid use of installments"),
    ECDA105(105, "Card Withdraw not enabled for recipient."),
    ECDA120(120, "Boleto payment has been rejected by DDA: %s"),
    ECDA121(121, "Transaction in unsupported status: %s"),
    ECDA122(122, "Maximum Boleto payment date and/or time limit exceeded."),
    ECDA123(123, "Maximum Utilities payment date and/or time limit exceeded."),
    ECDA141(141, "Incorrect transaction status"),
    ECDA151(151, "Transaction already exists"),
    ECDA161(161, "Invalid amount"),
    ECDA191(191, "CVV required"),
    ECDA202(202, "Invalid attempt"),
    ECDA201(201, "Invalid card number or brand"),
    ECDA203(203, "Credit card validation is disabled"),
    ECDA204(204, "Credit card can't be validated"),
    ECDA301(301, "Credit card is blocked"),
    ECDA302(302, "Installments not supported"),
    ECDA303(303, "Invalid CVV"),
    ECDA304(304, "Min value required"),
    ECDA305(305, "Min value required for installments"),
    ECDA306(306, "Operation not supported"),
    ECDA307(307, "Transaction was cancelled"),
    ECDA308(308, "There is no credit card configuration for the card bin: %s"),
    ECDA309(309, "Operation is not valid for this card"),
    ECDA310(310, "Credit card gateway communication error"),
    ECDA491(491, "Unable to send SMS"),
    ECDA691(691, "An account with the given phone number already exists"),
    ECDA701(701, "Invalid digital check string: %s"),
    ECDA702(702, "Invalid digital check value: %s"),
    ECDA704(704, "Digital check already processed"),
    ECDA705(705, "Invalid signature"),
    ECDA706(706, "Digital check value (%s) is not the same as the expected one (%s)"),
    ECDA708(708, "Missing required parameter: %s"),
    ECDA711(711, "Digital check has expired"),
    ECDA771(771, "Unknown card"),
    ECDA801(801, "Missing history code"),
    ECDA981(981, "Acquirer internal error");

    private final Integer errorId;
    private final String message;
    private final Exception mappedInternalException;

    ApiErrorCodesEnum(Integer errorId, String message) {
        this.errorId = errorId;
        this.message = message;
        this.mappedInternalException = null;
    }

    ApiErrorCodesEnum(Integer errorId, String message, Exception mappedInternalErrorCodesEnum) {
        this.errorId = errorId;
        this.message = message;
        this.mappedInternalException = mappedInternalErrorCodesEnum;
    }

    public Integer getErrorId() {
        return errorId;
    }

    public Exception getMappedInternalException() {
        return mappedInternalException;
    }
}