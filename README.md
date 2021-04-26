# java-handle-exception-api-2
handle exception api 2


# Usando ControllerAdvice
Quando você cria uma classe anotada com @ControllerAdvice, ela tratará as exceções criadas por todos os seus controller. Cada controller advice um método com uma anotação @ExceptionHandler que se torna o manipulador padrão. Você pode inserir seu código personalizado para imprimir ou rastrear erros.

````
@ControllerAdvice
class GlobalDefaultExceptionHandler {
  @ExceptionHandler(value = Exception.class)
  public ModelAndView
  defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
  // handle error here
  }
}
````
