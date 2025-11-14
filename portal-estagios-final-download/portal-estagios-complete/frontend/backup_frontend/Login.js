import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { saveToken } from './auth';

export default function Login(){
  const [email,setEmail]=useState('');
  const [senha,setSenha]=useState('');
  const [error,setError]=useState(null);
  const nav = useNavigate();

  const submit = async (e)=>{
    e.preventDefault();
    const res = await fetch('/api/auth/login',{method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify({email,senha})});
    const data = await res.json();
    if(data.token){ saveToken(data.token); nav('/'); }
    else setError(data.error || 'Erro ao logar');
  }

  return (
    <div style={{padding:20}}>
      <h2>Login</h2>
      <form onSubmit={submit}>
        <div><input placeholder='email' value={email} onChange={e=>setEmail(e.target.value)} required/></div>
        <div><input placeholder='senha' type='password' value={senha} onChange={e=>setSenha(e.target.value)} required/></div>
        <button type='submit'>Entrar</button>
      </form>
      {error && <p style={{color:'red'}}>{error}</p>}
    </div>
  );
}
