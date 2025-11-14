export function saveToken(token){ localStorage.setItem('token', token); }
export function getToken(){ return localStorage.getItem('token'); }
export function clearToken(){ localStorage.removeItem('token'); }
export function authFetch(url, options={}){
  const token = getToken();
  const headers = options.headers || {};
  if(token) headers['Authorization'] = 'Bearer ' + token;
  headers['Content-Type'] = headers['Content-Type'] || 'application/json';
  return fetch(url, {...options, headers});
}


export function decodeToken(token){
  if(!token) return null;
  try{
    const parts = token.split('.');
    if(parts.length<2) return null;
    const payload = parts[1].replace(/-/g, '+').replace(/_/g, '/');
    const json = JSON.parse(decodeURIComponent(escape(atob(payload))));
    return json;
  }catch(e){ return null; }
}

export function getPerfil(){
  const token = getToken();
  const p = decodeToken(token);
  if(!p || !p.sub) return null;
  const parts = p.sub.split(':');
  return parts.length>1?parts[1] : null;
}
