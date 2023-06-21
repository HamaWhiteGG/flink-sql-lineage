import React,{useState, useEffect} from 'react'
import { Outlet } from 'react-router-dom'

const Page = () => {
  return (
    <div className='gray-bg'>
      <Outlet/>
    </div>
  )
}
export default Page