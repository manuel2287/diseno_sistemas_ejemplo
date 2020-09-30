package com.diseno.services;

import com.diseno.models.Usuario;

public interface IUsuarioService {
    Usuario findByUsername(String username);
}
