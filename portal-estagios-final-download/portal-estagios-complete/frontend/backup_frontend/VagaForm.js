import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { getToken } from './auth';

export default function VagaForm(){
  const { id } = useParams();
  const nav = useNavigate();
  const [model,setModel]=useState({titulo:'',descricao:'',area:'',localizacao:'',modalidade:'REMOTO',cargaHoraria:'',requisitos:''});

  useEffect(()=>{
    if(id && id!=='novo'){
      fetch('/api/vagas/'+id).then(r=>r.json()).then(d=>setModel(d));
    }
  },[id]);

  const submit = async (e)=>{
    e.preventDefault();
    const token = getToken();
    const method = id && id!=='novo' ? 'PUT' : 'POST';
    const url = id && id!=='novo' ? '/api/vagas/'+id : '/api/vagas';
    const res = await fetch(url, {method, headers:{'Content-Type':'application/json', 'Authorization':'Bearer '+token}, body:JSON.stringify(model)});
    if(res.ok) nav('/');
    else alert('Erro: talvez seu usuário não seja EMPRESA/admin');
  }

  return (
    <div style={{padding:20}}>
      <h2>{id && id!=='novo' ? 'Editar Vaga' : 'Nova Vaga'}</h2>
      <form onSubmit={submit}>
        <div><input placeholder='titulo' value={model.titulo||''} onChange={e=>setModel({...model,titulo:e.target.value})} required/></div>
        <div><textarea placeholder='descricao' value={model.descricao||''} onChange={e=>setModel({...model,descricao:e.target.value})} required/></div>
        <div><input placeholder='area' value={model.area||''} onChange={e=>setModel({...model,area:e.target.value})} /></div>
        <div><input placeholder='localizacao' value={model.localizacao||''} onChange={e=>setModel({...model,localizacao:e.target.value})} /></div>
        <div><select value={model.modalidade||'REMOTO'} onChange={e=>setModel({...model,modalidade:e.target.value})}>
          <option>REMOTO</option><option>PRESENCIAL</option><option>HÍBRIDO</option>
        </select></div>
        <div><input placeholder='cargaHoraria' value={model.cargaHoraria||''} onChange={e=>setModel({...model,cargaHoraria:e.target.value})} /></div>
        <div><input placeholder='requisitos' value={model.requisitos||''} onChange={e=>setModel({...model,requisitos:e.target.value})} /></div>
        <button type='submit'>Salvar</button>
      </form>
    </div>
  );
}
