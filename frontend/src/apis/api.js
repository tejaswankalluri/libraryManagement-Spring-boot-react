import { api } from "../config/config";

// Members
export const GetMembers = () => api.get("/member");
export const GetMembersCount = () => api.get("/member/count");
export const PostMember = (data) => api.post("/member", data);

// loans
export const GetLoanCount = () => api.get("/loan/count");

// books
export const GetBooksCount = () => api.get("/book/count");
