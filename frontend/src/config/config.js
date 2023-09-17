import axios from "axios";
export const APIURL = "http://localhost:8080/api/v1";
export const api = axios.create({
  baseURL: APIURL,
});
