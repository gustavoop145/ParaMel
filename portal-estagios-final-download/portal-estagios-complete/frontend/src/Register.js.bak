import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { API_URL } from './config';
export default function Register() {
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [perfil, setPerfil] = useState('ALUNO');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  async function handleSubmit(e) {
    e.preventDefault();
    setLoading(true);
    try {
      const res = await fetch(`${API_URL}/api/auth/register`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, email, senha, perfil })
      });

      // Se servidor retornar vazio/sem body, tratamos
      if (!res.ok) {
        const text = await res.text().catch(()=>null);
        throw new Error(text || `HTTP ${res.status}`);
      }

      // tenta ler JSON, mas trata caso não venha JSON
      let data = null;
      try { data = await res.json(); } catch(_){}

      // se existir token, armazena e redireciona
      if (data && data.token) {
        localStorage.setItem('token', data.token);
        alert('Registrado com sucesso!');
        navigate('/');
      } else {
        alert('Registrado (sem token retornado).');
        navigate('/');
      }
    } catch (err) {
      console.error('erro register:', err);
      alert('Erro ao registrar: ' + (err.message || 'Erro desconhecido'));
    } finally {
      setLoading(false);
    }
  }

  return (
    <div style={{ padding: 20 }}>
      <h1>Registrar</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Nome<br/>
            <input value={nome} onChange={e=>setNome(e.target.value)} />
          </label>
        </div>
        <div>
          <label>Email<br/>
            <input value={email} onChange={e=>setEmail(e.target.value)} />
          </label>
        </div>
        <div>
          <label>Senha<br/>
            <input type="password" value={senha} onChange={e=>setSenha(e.target.value)} />
          </label>
        </div>
        <div>
          <label>Perfil<br/>
            <select value={perfil} onChange={e=>setPerfil(e.target.value)}>
              <option value="ALUNO">ALUNO</option>
              <option value="EMPRESA">EMPRESA</option>
              <option value="ADMIN">ADMIN</option>
            </select>
          </label>
        </div>
        <div style={{ marginTop: 10 }}>
          <button type="submit" disabled={loading}>
            {loading ? 'Enviando...' : 'Registrar'}
          </button>
        </div>
      </form>
    </div>
  );
}
