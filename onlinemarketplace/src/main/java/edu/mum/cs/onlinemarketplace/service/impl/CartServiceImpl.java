package edu.mum.cs.onlinemarketplace.service.impl;

import edu.mum.cs.onlinemarketplace.domain.Cart;
import edu.mum.cs.onlinemarketplace.repository.CartRepository;
import edu.mum.cs.onlinemarketplace.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public void removeOrderById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
