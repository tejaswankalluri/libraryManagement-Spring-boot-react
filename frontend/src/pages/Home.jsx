import { Link } from "react-router-dom";
import { Navbar } from "../components/Navbar";
import { useQuery } from "@tanstack/react-query";
import { GetBooksCount, GetLoanCount, GetMembersCount } from "../apis/api";
export function Home() {
  const { data: membersCountData } = useQuery({
    queryKey: ["memberCount"],
    queryFn: GetMembersCount,
  });
  const { data: loanCountData } = useQuery({
    queryKey: ["loanCount"],
    queryFn: GetLoanCount,
  });
  const { data: bookCountData } = useQuery({
    queryKey: ["bookCount"],
    queryFn: GetBooksCount,
  });
  return (
    <>
      <Navbar />
      <div className="container mx-auto mt-3">
        <h2 className="text-3xl font-extrabold text-gray-800">
          Library Management
        </h2>
        <hr className="h-px my-8 bg-gray-200 border-0" />
        <div className="flex flex-row space-x-5 md:justify-evenly">
          <Link
            to="members"
            className="block w-80 p-6 bg-white border border-gray-200 rounded-lg shadow hover:shadow-md"
          >
            <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-700">
              Users
            </h5>
            <p className="font-bold text-5xl text-red-400">
              {membersCountData?.data?.count}
            </p>
          </Link>
          <a
            href="#"
            className="block w-80 p-6 bg-white border border-gray-200 rounded-lg shadow hover:shadow-md"
          >
            <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-700">
              Loans
            </h5>
            <p className="font-bold text-5xl text-green-400">
              {loanCountData?.data?.count}
            </p>
          </a>
          <a
            href="#"
            className="block w-80 p-6 bg-white border border-gray-200 rounded-lg shadow hover:shadow-md"
          >
            <h5 className="mb-2 text-2xl font-bold tracking-tight text-gray-700">
              Books
            </h5>
            <p className="font-bold text-5xl text-yellow-400">
              {bookCountData?.data?.count}
            </p>
          </a>
        </div>
      </div>
    </>
  );
}
