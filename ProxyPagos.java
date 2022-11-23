/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patrones_arias_acosta;

/**
 *
 * @author david
 */
public class ProxyPagos extends Pagos{

    Pagos pago;
    
    @Override
    public boolean pagar(double saldo, double total) {
        if(saldo >= total)
            return true;
        else return false;
            
    }
    
}
