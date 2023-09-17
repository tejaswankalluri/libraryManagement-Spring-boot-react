import { Link } from "react-router-dom";
import { Navbar } from "../components/Navbar";
import { AddMember } from "../components/AddMember";
import { useState } from "react";
import { useQuery } from "@tanstack/react-query";
import { GetMembers } from "../apis/api";

export function Members() {
  const { data: membersData } = useQuery({
    queryKey: ["member"],
    queryFn: GetMembers,
  });
  const [open, setOpen] = useState(false);
  return (
    <>
      <Navbar />
      {open ? <AddMember open={open} setOpen={setOpen} /> : null}
      <div className="mx-auto container flex justify-between mt-3">
        <h2 className="text-3xl font-extrabold text-gray-800">Members</h2>
        <button
          type="button"
          className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 focus:outline-none self-end"
          onClick={() => setOpen(true)}
        >
          Add Member
        </button>
      </div>
      <div className="mx-auto container">
        <hr className="h-px my-6 bg-gray-200 border-0" />
        <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
          <table className="w-full text-sm text-left text-gray-500">
            <thead className="text-xs text-gray-700 uppercase bg-gray-50">
              <tr>
                <th scope="col" className="px-6 py-3">
                  First Name
                </th>
                <th scope="col" className="px-6 py-3">
                  Last Name
                </th>
                <th scope="col" className="px-6 py-3">
                  Email
                </th>
                <th scope="col" className="px-6 py-3">
                  Phone
                </th>
                <th scope="col" className="px-6 py-3">
                  Action
                </th>
              </tr>
            </thead>
            <tbody>
              {membersData?.data?.map((member) => (
                <tr className="bg-white border-b" key={member.id}>
                  <th
                    scope="row"
                    className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap"
                  >
                    {member.firstName}
                  </th>
                  <td className="px-6 py-4">{member.lastName}</td>
                  <td className="px-6 py-4">{member.email}</td>
                  <td className="px-6 py-4">{member.phone}</td>
                  <td className="px-6 py-4">
                    <Link className="font-medium text-blue-600 dark:text-blue-500 hover:underline">
                      Edit
                    </Link>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}
