package donguk.server.service;

import donguk.server.domain.Cart;
import donguk.server.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;


    public void save(Cart cart) {
        cartRepository.save(cart);
    }


}
