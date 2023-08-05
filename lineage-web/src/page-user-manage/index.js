import React,{useState, useEffect} from 'react'
import { Outlet, Link } from 'react-router-dom'
import { Tabs } from 'antd'

const Page = () => {
  const items = [
    {
      key: 'user',
      label: <Link to='/user-manage/user'>User</Link>,
    },{
      key: 'role',
      label: <Link to='/user-manage/role'>Role</Link>,
    }]
  return (
    <div className='gray-bg'>
      <div className='m8 pl16 pr16 pt16 white-bg'>
        <div className='fs28 mb16'>User Management</div>
        <Tabs items={items} />
      </div>
      <Outlet/>
    </div>
  )
}
export default Page