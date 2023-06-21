import React,{useState, useEffect} from 'react'
import { Outlet } from 'react-router-dom'
import './index.css'

const Page = () => {
  return (
    <div className='gray-bg'>
      <Outlet/>
    </div>
  )
}
export default Page