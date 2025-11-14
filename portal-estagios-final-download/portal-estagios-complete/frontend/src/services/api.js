import { API_URL } from './config';
export const API_URL = "http://localhost:8080";
export function authHeader() {
  const t = localStorage.getItem('token');
  return t ? { "Authorization": "Bearer " + t } : {};
}
