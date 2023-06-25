
import React,{ useEffect, useState } from 'react'
import { Outlet, Link, useParams, useNavigate } from 'react-router-dom'
import { UploadOutlined, UserOutlined, VideoCameraOutlined, FileTextOutlined, ProfileOutlined, GithubOutlined, BranchesOutlined, SettingOutlined } from '@ant-design/icons';
import { Layout, Menu, theme, Button, Tooltip } from 'antd'
import './common/common.styl'

const { Header, Content, Footer, Sider } = Layout
const App = () => {
  const [collapsed, setCollapsed] = useState(false)
  const {hash} = window.location
  const [current, setCurrent] = useState(hash.split('/')[1])
  console.log()
  const {
    token: { colorBgContainer },
  } = theme.useToken()

  const menuMap = [
    {
      key: 'job',
      icon: BranchesOutlined,
      label: 'Job',
      url: 'job',
    },
    // {
    //   key: 'catalog',
    //   icon: FileTextOutlined,
    //   label: 'Catalog',
    //   url: 'catalog',
    // },
    {
      key: 'catalog',
      icon: SettingOutlined,
      label: 'Catalog',
      url: 'catalog',
    },
    {
      key: 'plugin',
      icon: SettingOutlined,
      label: 'Plugin',
      url: 'plugin',
    },
    {
      key: 'user-manage',
      icon: SettingOutlined,
      label: 'User manage',
      url: 'user-manage',
    },
  ]

  const onClick = (e) => {
    console.log('click ', e);
    setCurrent(e.key);
  }
  
  return (
    <Layout>
      <Sider
        breakpoint="lg"
      >
        <div className="logo" />
        <Menu
          theme="dark"
          mode="inline"
          selectedKeys={[current]}
          onClick={onClick}
          items={menuMap.map(
            (item) => ({
              key: item.key,
              icon: React.createElement(item.icon),
              label: <Link 
              to={`/${item.url}`}
            >{item.label}</Link>,
            }),
          )
        }
        />
      </Sider>
      <Layout>
        <Header
          className="FBV FBAE header-box"
        >
          <div className=''>
            <Tooltip title='Document'>
              <ProfileOutlined style={{color: '#fff', fontSize: 16}} className='mr32 hand' />
            </Tooltip>
            <Tooltip title='GitHub'>
              <GithubOutlined style={{color: '#fff', fontSize: 16}} className='mr32 hand' />
            </Tooltip>
            <Button type='link'>EN</Button>
          </div>
        </Header>
        <Content
          style={{
          }}
        >
          <div
            style={{
              minHeight: 360,
              background: colorBgContainer,
            }}
          >
            <Outlet />
          </div>
        </Content>
        <Footer
          style={{
            textAlign: 'center',
          }}
        >
          Flink SQL Lineage  ©2023
        </Footer>
      </Layout>
    </Layout>
  );
}

export default App
